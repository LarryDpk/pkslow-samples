

find $path -type f -name "*.env"

# assign to array
env_array=(`find $path -type f -name "*.env"`)

# Loop
for env_file in ${env_array[@]}
do
  echo "$env_file"
done



