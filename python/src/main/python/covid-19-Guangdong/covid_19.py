import csv
import matplotlib.pyplot as plt
import pyexcel as p
from datetime import datetime
from matplotlib import animation


def excel_to_datatime(excel_date):
    dt = datetime.fromordinal(datetime(1900, 1, 1).toordinal() + excel_date - 2)
    return dt


def datetime_to_str(dt, pattern):
    return pattern.format(dt.month, dt.day)


def load_data():
    records = p.get_records(file_name="covid-19.xlsx")
    print(records)
    data_x = []
    data_y1 = []
    data_y2 = []
    for record in records[1:]:
        dt = excel_to_datatime(record['-1'])
        data_x.append(dt)
        data_y1.append(record['-6'])
        data_y2.append(record['-7'])
    return data_x, data_y1, data_y2


def read_data_from_csv(file_name):
    data_x = []
    data_y1 = []
    data_y2 = []
    with open(file_name) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line_count = 0
        for row in csv_reader:
            if line_count == 0:
                print(f'Column names are {", ".join(row)}')
                line_count += 1
            else:
                date = datetime.strptime(row[0], '%Y-%m-%d')
                # 只要11月开始的数据
                if date < datetime(2022, 11, 1):
                    continue
                data_x.append(date)
                data_y1.append(int(row[1]) + int(row[3]))
                data_y2.append(int(row[2]) + int(row[4]))
                line_count += 1
        print(f'Read {line_count - 1} lines.')

    return data_x, data_y1, data_y2


def get_xticks_show_data(data_x):
    # x轴的显示
    xt = range(len(data_x) + 1)
    xt = xt[1:]
    x_index_show = []
    x_show = []
    for i, item in enumerate(data_x):
        if (i + 1) % interval_show == remainder:
            x_show.append(datetime_to_str(item, '{}-{}'))
            x_index_show.append(i + 1)
    return x_index_show, x_show


if __name__ == '__main__':
    data_x, data_y1, data_y2 = read_data_from_csv('../beautifulsoup4-example/covid-19.csv')
    # data_x, data_y1, data_y2 = load_data()
    length = len(data_x)
    # 显示间隔，避免数据太多太密集，而看不清楚
    interval_show = 2
    remainder = length % interval_show

    fig = plt.figure(figsize=(15, 20), dpi=240)
    ax = plt.axes(xlim=(0, length + 1), ylim=(0, 10000))
    line1, = ax.plot([], [], linewidth=2.0, color='tomato')
    line2, = ax.plot([], [], linewidth=2.0, color='lightskyblue')

    # 为了支持中文显示
    plt.rcParams['font.family'] = ['Heiti TC']
    plt.rcParams['font.sans-serif'] = ['Heiti TC']
    plt.title('广东病例新增变化', color='dimgray', fontsize=30)

    text_date = ax.text(2, 9000, '', ha='left', color='black', fontsize=20)
    text_gd = ax.text(2, 8700, '广东新增', ha='left', color='red', fontsize=20)
    text_gz = ax.text(2, 8400, '广州新增', ha='left', color='blue', fontsize=20)

    text1 = ax.text(0, 0, '', ha='center', color='red', fontsize=10)
    text2 = ax.text(0, 0, '', ha='center', color='blue', fontsize=10)

    x_index_show, x_show = get_xticks_show_data(data_x)
    plt.xticks(x_index_show, x_show)


    # initialization function: plot the background of each frame
    def init():
        line1.set_data([], [])
        line2.set_data([], [])
        return line1, line2, text_gd, text_gz, text_date


    # animation function.  This is called sequentially
    def animate(i):
        print('Processing {} for {}'.format(i + 1, data_x[i]))
        x = range(i + 2)
        x = x[1:]
        line1.set_data(x, data_y1[:i + 1])
        line2.set_data(x, data_y2[:i + 1])
        if (i + 1) % interval_show == remainder or (i + 1) >= length - 5:
            ax.text(i + 1, data_y1[i] + 150, data_y1[i], ha='center', color='red', fontsize=8)
            ax.text(i + 1, data_y2[i] - 150, data_y2[i], ha='center', color='blue', fontsize=8)
        text_gd.set_text('广东新增：' + str(data_y1[i]))
        text_gz.set_text('广州新增：' + str(data_y2[i]))
        text_date.set_text(datetime_to_str(data_x[i], '2022年{}月{}日'))
        plt.scatter(x, data_y1[:i + 1], color='bisque')
        plt.scatter(x, data_y2[:i + 1], color='cyan')
        return line1, line2, text_gd, text_gz, text_date


    # call the animator.  blit=True means only re-draw the parts that have changed.
    anim = animation.FuncAnimation(fig, animate, init_func=init,
                                   frames=len(data_y1), interval=1, blit=True)

    plt.rcParams['animation.ffmpeg_path'] = '/Users/larry/Software/ffmpeg/ffmpeg'
    anim.save('covid-19-Guangdong.mp4', fps=1, extra_args=['-vcodec', 'libx264'])

    # 保存图片
    plt.savefig('covid-19.png')
