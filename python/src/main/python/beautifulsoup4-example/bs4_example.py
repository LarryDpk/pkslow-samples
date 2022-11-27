import requests
from bs4 import BeautifulSoup
import re
import csv


def fetch_links():
    url = "http://wsjkw.gd.gov.cn/xxgzbdfk/"
    # url = "http://wsjkw.gd.gov.cn/xxgzbdfk/index_2.html"
    req = requests.get(url)
    soup = BeautifulSoup(req.content, 'lxml')
    links = soup.findAll('a')
    valid_links_filter = filter(lambda item: 'title' in item.attrs and '广东省新冠肺炎疫情情况' in item.attrs['title'],
                                links)
    valid_links = list(valid_links_filter)
    return valid_links


def fetch_content(url):
    req = requests.get(url)
    soup = BeautifulSoup(req.content, 'lxml')
    ps = soup.findAll('p')
    valid_ps_filter = filter(lambda item: '全省新增本土确诊病例' in item.text,
                             ps)
    valid_ps = list(valid_ps_filter)

    if not valid_ps:
        ps = soup.findAll('span')
    valid_ps_filter = filter(lambda item: '全省新增本土确诊病例' in item.text,
                             ps)
    valid_ps = list(valid_ps_filter)

    valid_p = valid_ps[0]
    return valid_p.text


def parse_data(str):
    confirm_str = re.search('全省新增本土确诊病例\\d+例', str)
    confirm_str = re.search('\\d+', confirm_str.group())
    confirm_gd = int(confirm_str.group())

    asymptomatic_str = re.search('新增本土无症状感染者\\d+例', str)
    asymptomatic_str = re.search('\\d+', asymptomatic_str.group())
    asymptomatic_gd = int(asymptomatic_str.group())

    gz_strs = re.findall('广州\\d+例', str)
    gz_str = re.search('\\d+', gz_strs[0])
    confirm_gz = int(gz_str.group())

    gz_str = re.search('\\d+', gz_strs[1])
    asymptomatic_gz = int(gz_str.group())

    return confirm_gd, confirm_gz, asymptomatic_gd, asymptomatic_gz


def read_data_from_csv(file_name):
    data_store = []
    with open(file_name) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line_count = 0
        for row in csv_reader:
            if line_count == 0:
                print(f'Column names are {", ".join(row)}')
                line_count += 1
            else:
                data_store.append(row)
                print(f'{row[0]}, {row[1]}, {row[2]}, {row[3]}, {row[4]}')
                line_count += 1
        print(f'Read {line_count} lines.')

    return data_store


def is_exist(data_store, date):
    already_exist = False

    for row in data_store:
        if row[0] == date:
            return True

    return already_exist


if __name__ == '__main__':
    data_store = read_data_from_csv('covid-19.csv')
    valid_links = fetch_links()
    valid_links.reverse()

    with open('covid-19.csv', 'a') as covid_file:
        covid_writer = csv.writer(covid_file, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
        for link in valid_links:
            date = link.nextSibling.text
            if is_exist(data_store, date):
                continue

            content = fetch_content(link.attrs['href'])
            confirm_gd, confirm_gz, asymptomatic_gd, asymptomatic_gz = parse_data(content)
            covid_writer.writerow([link.nextSibling.text, confirm_gd, confirm_gz, asymptomatic_gd, asymptomatic_gz])
