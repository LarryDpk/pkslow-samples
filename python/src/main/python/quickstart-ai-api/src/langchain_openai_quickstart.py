from langchain_openai import ChatOpenAI
from langchain_core.messages import HumanMessage, SystemMessage

model = ChatOpenAI(model="gpt-4o-mini")
messages = [
    SystemMessage(content="Translate the following from English into Chinese"),
    HumanMessage(content="hi, how are you?"),
]
result = model.invoke(messages)
print(result.content)

# prompt template example
from langchain_core.prompts import ChatPromptTemplate

system_template = "Translate the following into {language}:"
prompt_template = ChatPromptTemplate.from_messages(
    [("system", system_template), ("user", "{text}")]
)
result_template = prompt_template.invoke({"language": "italian", "text": "hi, how are you?"})
print(result_template)
result_template = prompt_template.invoke({"language": "Chinese", "text": "hi, how are you?"})
print(result_template)

result = model.invoke(result_template)
print(result.content)

