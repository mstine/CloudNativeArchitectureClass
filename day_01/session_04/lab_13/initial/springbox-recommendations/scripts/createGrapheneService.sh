#!/bin/bash
URL="your graphenedb url"
USERNAME="your graphenedb username"
PASSWORD="your graphenedb password"

X=$IFS
IFS='/'

TOKENS=( $URL )
SEC_URL=${TOKENS[0]}//${USERNAME}:${PASSWORD}@${TOKENS[2]}/${TOKENS[3]}/${TOKENS[4]}

IFS=$X

JSON=`printf '{"neo4jUri":"%s"}' $SEC_URL`
cf cups springbox-recommendations-db -p ${JSON}
