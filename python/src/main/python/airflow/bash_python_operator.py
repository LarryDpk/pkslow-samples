from datetime import datetime

from airflow import DAG
from airflow.models.baseoperator import chain
from airflow.operators.bash import BashOperator
from airflow.operators.empty import EmptyOperator

from airflow.operators.python import PythonOperator

dag_test = DAG(
    dag_id="pkslow_test_dag",
    start_date=datetime(2023, 6, 13, 5, 12, 0),
    schedule_interval='*/10 * * * *',
)

generate_random_number = BashOperator(
    task_id="generate_random_number",
    bash_command='echo $RANDOM',
    dag=dag_test,
)


def print_message():
    print("This is a Python Operator by www.pkslow.com.")


python_task = PythonOperator(
    task_id="print_message",
    python_callable=print_message,
    dag=dag_test
)

t0 = EmptyOperator(task_id="t0")
t1 = EmptyOperator(task_id="t1")
t2 = EmptyOperator(task_id="t2")
t3 = EmptyOperator(task_id="t3")
t4 = EmptyOperator(task_id="t4")
t5 = EmptyOperator(task_id="t5")
t6 = EmptyOperator(task_id="t6")

chain(generate_random_number, python_task, t0, t1, [t2, t3], [t4, t5], t6)
