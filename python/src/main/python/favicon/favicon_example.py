import requests
import favicon
from urllib.parse import urlparse

url = 'https://www.pkslow.com/'
domain = urlparse(url).netloc

icons = favicon.get(url)
icon = icons[0]

# save to local
response = requests.get(icon.url, stream=True)
with open('{}.favicon.{}'.format(domain, icon.format), 'wb') as image:
    for chunk in response.iter_content(1024):
        image.write(chunk)
