from langchain_openai import ChatOpenAI
from langchain_core.messages import HumanMessage, SystemMessage

model = ChatOpenAI(model="gpt-4o-mini")
messages = [
    SystemMessage(content="Translate the following from English into Chinese"),
    HumanMessage(content="hi, how are you?"),
]
result = model.invoke(messages)

print(result.content)



