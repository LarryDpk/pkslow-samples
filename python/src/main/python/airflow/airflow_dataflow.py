from airflow import DAG
import airflow
from datetime import timedelta

from airflow.providers.apache.beam.operators.beam import BeamRunPythonPipelineOperator

default_args = {
    'owner': 'Airflow',
    # 'start_date':airflow.utils.dates.days_ago(1),
    'retries': 1,
    'retry_delay': timedelta(seconds=50),
    'dataflow_default_options': {
        'project': 'pkslow-gcp',
        'region': 'us-west1',
        'runner': 'DataflowRunner'
    }
}

dag = DAG(
    dag_id='pkslow_dataflow',
    default_args=default_args,
    schedule_interval='@daily',
    start_date=airflow.utils.dates.days_ago(1),
    catchup=False,
    description="DAG for data ingestion and transformation"
)


dataflow_task = BeamRunPythonPipelineOperator(
    task_id='pkslow_dataflow_job',
    py_file='gs://us-central1-pkslow-composer-d7602fc1-bucket/py_scripts/apache_beam_word_count.py',
    runner='DataFlowRunner',
    pipeline_options={
        'input': 'gs://dataflow-samples/shakespeare/kinglear.txt',
        'output': 'gs://pkslow-gcp-dataflow/results/outputs',
        'temp_location': 'gs://pkslow-gcp-dataflow/tmp/',
    },
    dag=dag
)

