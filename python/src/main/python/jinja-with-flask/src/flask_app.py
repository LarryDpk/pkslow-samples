from flask import Flask, render_template

app = Flask(__name__)


@app.route("/")
def home():
    return render_template("index.html", title='main page')


@app.route("/list")
def default():
    return render_template("list.html", title='Skill List',
                           skills=['Java', 'Python', 'Docker', 'Kubernetes', "Google Cloud Platform"])


if __name__ == "__main__":
    app.run(debug=False)
