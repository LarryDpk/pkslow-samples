#!/bin/bash

# Variables
DAYS_VALID=365
KEYSTORE_PASSWORD="keystore-password"
TRUSTSTORE_PASSWORD="truststore-password"
CA_CERT="ca-cert.pem"
CA_KEY="ca-key.pem"
CA_SUBJECT="/CN=MyKafkaCA"
BROKER_ALIAS="kafka-broker"
CLIENT_ALIAS="kafka-client"
BROKER_SUBJECT="CN=kafka-broker"
CLIENT_SUBJECT="CN=kafka-client"

# Paths
BROKER_KEYSTORE="kafka.broker.keystore.jks"
BROKER_TRUSTSTORE="kafka.broker.truststore.jks"
CLIENT_KEYSTORE="kafka.client.keystore.jks"
CLIENT_TRUSTSTORE="kafka.client.truststore.jks"
BROKER_CSR="kafka-broker.csr"
CLIENT_CSR="kafka-client.csr"
BROKER_CERT="kafka-broker-cert.pem"
CLIENT_CERT="kafka-client-cert.pem"

# Step 1: Create a Certificate Authority (CA)
echo "Creating Certificate Authority (CA)..."
openssl genpkey -algorithm RSA -out $CA_KEY
openssl req -new -x509 -key $CA_KEY -out $CA_CERT -days $DAYS_VALID -subj $CA_SUBJECT

# Step 2: Create Keystore and CSR for Kafka Broker
echo "Creating keystore and CSR for Kafka Broker..."
keytool -genkeypair -alias $BROKER_ALIAS -keyalg RSA -keystore $BROKER_KEYSTORE \
  -storepass $KEYSTORE_PASSWORD -keypass $KEYSTORE_PASSWORD -dname $BROKER_SUBJECT

keytool -certreq -alias $BROKER_ALIAS -keystore $BROKER_KEYSTORE \
  -file $BROKER_CSR -storepass $KEYSTORE_PASSWORD

# Step 3: Sign Broker CSR with CA
echo "Signing Broker CSR with CA..."
openssl x509 -req -CA $CA_CERT -CAkey $CA_KEY -in $BROKER_CSR \
  -out $BROKER_CERT -days $DAYS_VALID -CAcreateserial

# Step 4: Import CA Cert and Broker Cert into Broker Keystore
echo "Importing CA and Broker certificates into Broker keystore..."
keytool -importcert -alias ca-cert -file $CA_CERT -keystore $BROKER_KEYSTORE \
  -storepass $KEYSTORE_PASSWORD -noprompt

keytool -importcert -alias $BROKER_ALIAS -file $BROKER_CERT \
  -keystore $BROKER_KEYSTORE -storepass $KEYSTORE_PASSWORD -noprompt

# Step 5: Create Truststore for Kafka Broker
echo "Creating Truststore for Kafka Broker..."
keytool -importcert -alias ca-cert -file $CA_CERT -keystore $BROKER_TRUSTSTORE \
  -storepass $TRUSTSTORE_PASSWORD -noprompt

# Step 6: Create Keystore and CSR for Kafka Client
echo "Creating keystore and CSR for Kafka Client..."
keytool -genkeypair -alias $CLIENT_ALIAS -keyalg RSA -keystore $CLIENT_KEYSTORE \
  -storepass $KEYSTORE_PASSWORD -keypass $KEYSTORE_PASSWORD -dname $CLIENT_SUBJECT

keytool -certreq -alias $CLIENT_ALIAS -keystore $CLIENT_KEYSTORE \
  -file $CLIENT_CSR -storepass $KEYSTORE_PASSWORD

# Step 7: Sign Client CSR with CA
echo "Signing Client CSR with CA..."
openssl x509 -req -CA $CA_CERT -CAkey $CA_KEY -in $CLIENT_CSR \
  -out $CLIENT_CERT -days $DAYS_VALID -CAcreateserial

# Step 8: Import CA Cert and Client Cert into Client Keystore
echo "Importing CA and Client certificates into Client keystore..."
keytool -importcert -alias ca-cert -file $CA_CERT -keystore $CLIENT_KEYSTORE \
  -storepass $KEYSTORE_PASSWORD -noprompt

keytool -importcert -alias $CLIENT_ALIAS -file $CLIENT_CERT \
  -keystore $CLIENT_KEYSTORE -storepass $KEYSTORE_PASSWORD -noprompt

# Step 9: Create Truststore for Kafka Client
echo "Creating Truststore for Kafka Client..."
keytool -importcert -alias ca-cert -file $CA_CERT -keystore $CLIENT_TRUSTSTORE \
  -storepass $TRUSTSTORE_PASSWORD -noprompt

echo "SSL certificates generation completed!"


keytool -importkeystore -srckeystore kafka.client.keystore.jks \
  -destkeystore kafka.client.keystore.p12 -deststoretype PKCS12 \
  -srcstorepass $KEYSTORE_PASSWORD -deststorepass $KEYSTORE_PASSWORD

openssl pkcs12 -in kafka.client.keystore.p12 -nocerts -out kafka-client-key.pem -nodes -passin pass:$KEYSTORE_PASSWORD
