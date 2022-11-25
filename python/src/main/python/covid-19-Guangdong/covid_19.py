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


data_x, data_y1, data_y2 = load_data()

# fig = plt.figure(figsize=(16, 9), dpi=240)
fig = plt.figure(figsize=(15, 20), dpi=240)
ax = plt.axes(xlim=(0, 28), ylim=(0, 10000))
# ax = plt.axes(xlim=(0, 25), ylim=(0, 6000))
line1, = ax.plot([], [], linewidth=2.0, color='tomato')
line2, = ax.plot([], [], linewidth=2.0, color='lightskyblue')

# 为了支持中文显示
plt.rcParams['font.family'] = ['Heiti TC']
plt.title('广东病例新增变化', color='dimgray', fontsize=30)

text_date = ax.text(2, 9000, '', ha='left', color='black', fontsize=20)
text_gd = ax.text(2, 8700, '广东新增', ha='left', color='red', fontsize=20)
text_gz = ax.text(2, 8400, '广州新增', ha='left', color='blue', fontsize=20)

text1 = ax.text(0, 0, '', ha='center', color='red', fontsize=10)
text2 = ax.text(0, 0, '', ha='center', color='blue', fontsize=10)

# x轴的显示
xt = range(len(data_x) + 1)
xt = xt[1:]
dx_show = []
for item in data_x:
    dx_show.append(datetime_to_str(item, '{}-{}'))
plt.xticks(xt, dx_show)


# initialization function: plot the background of each frame
def init():
    line1.set_data([], [])
    line2.set_data([], [])
    return line1, line2, text1, text2, text_gd, text_gz, text_date


# animation function.  This is called sequentially
def animate(i):
    # if i == 15:
    #     plt.axes(xlim=(0, 25), ylim=(0, 10000))

    # x = dx[:i]
    print('Processing {} for {}'.format(i, data_x[i]))
    x = range(i + 2)
    x = x[1:]
    line1.set_data(x, data_y1[:i + 1])
    line2.set_data(x, data_y2[:i + 1])
    text1 = ax.text(i + 1, data_y1[i] + 150, data_y1[i], ha='center', color='red', fontsize=8)
    text2 = ax.text(i + 1, data_y2[i] - 150, data_y2[i], ha='center', color='blue', fontsize=8)
    text_gd.set_text('广东新增：' + str(data_y1[i]))
    text_gz.set_text('广州新增：' + str(data_y2[i]))
    text_date.set_text(datetime_to_str(data_x[i], '2022年{}月{}日'))
    plt.scatter(x, data_y1[:i + 1], color='bisque')
    plt.scatter(x, data_y2[:i + 1], color='cyan')
    return line1, line2, text1, text2, text_gd, text_gz, text_date


# call the animator.  blit=True means only re-draw the parts that have changed.
anim = animation.FuncAnimation(fig, animate, init_func=init,
                               frames=len(data_y1), interval=1, blit=True)

plt.rcParams['animation.ffmpeg_path'] = '/Users/larry/Software/ffmpeg/ffmpeg'
anim.save('covid-19-Guangdong.mp4', fps=1, extra_args=['-vcodec', 'libx264'])
