import airflow
from airflow import DAG
from airflow.providers.google.cloud.operators.dataproc import DataprocSubmitJobOperator

PROJECT_ID = "pkslow-gcp"
CLUSTER_NAME = 'test'
REGION = 'us-central1'
PYSPARK_URI = f'gs://pkslow-gcp-dataproc/python-scripts/spark_gs.py'

PYSPARK_JOB = {
    "reference": {"project_id": PROJECT_ID},
    "placement": {"cluster_name": CLUSTER_NAME},
    "pyspark_job": {"main_python_file_uri": PYSPARK_URI, "args": [
        'gs://dataflow-samples/shakespeare/kinglear.txt', 'gs://pkslow-gcp-dataproc/result/'
    ]},
}

dag = DAG(
    dag_id='pkslow_dataproc',
    schedule_interval='@daily',
    start_date=airflow.utils.dates.days_ago(1),
    catchup=False,
    description="DAG for data ingestion and transformation"
)

pyspark_task = DataprocSubmitJobOperator(
    task_id="pkslow_pyspark_task",
    job=PYSPARK_JOB,
    region=REGION,
    project_id=PROJECT_ID,
    dag=dag
)
