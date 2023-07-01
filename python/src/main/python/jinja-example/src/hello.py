from jinja2 import Template
import pathlib


def render(name, website):
    current_path = pathlib.Path(__file__).parent.parent.resolve().__str__()
    print(current_path)

    file = open(current_path + '/templates/hello.md', 'r')
    content = file.read()
    file.close()
    template = Template(content)
    rendered_md = template.render(name=name, website=website, skills=['Java', 'Python', 'Docker', 'Kubernetes'])
    print(rendered_md)

    output = open(current_path + '/output/hello.' + website + '.md', 'w')
    output.write(rendered_md)
    output.close()
    return rendered_md


if __name__ == '__main__':
    render('Larry', 'www.pkslow.com')
    render('Deng', 'www.google.com')
