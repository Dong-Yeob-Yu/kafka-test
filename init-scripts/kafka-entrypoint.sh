#!/bin/sh

# ✅ Kafka KRaft 저장소 초기화 (처음 실행 시)
if [ ! -f /var/lib/kafka/data/meta.properties ]; then
  echo "Initializing Kafka KRaft storage..."
  /opt/kafka/bin/kafka-storage.sh format -t hYiSnflwTKagsUxKkTPffw -c /opt/kafka/config/kraft/server.properties
fi

# ✅ Kafka 실행
exec /opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/kraft/server.properties