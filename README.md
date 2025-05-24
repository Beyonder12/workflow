# Versioning Kogito

# Start
- docker network create kogito
- mvn clean package
- cd docker-compose
- docker compose up --build -d

# Link
- Swagger UI http://localhost:8080/q/swagger-ui
- Management Console http://localhost:8280/ProcessInstances/
- Task Console http://localhost:8380/TaskInbox/
- Keycloak http://localhost:8480

# Save SVG automatically
On Windows/Linux – File > Preferences > Settings   
On macOS – Code > Preferences > Settings   
From there, access menu Extension > BPMN (or DMN), and click on ‘Edit in settings.json’:   
"kogito.bpmn.runOnSave": "extension.kogito.silentlyGenerateSvgBpmn",   
"kogito.dmn.runOnSave": "extension.kogito.silentlyGenerateSvgDmn",   


# Main API
- Get All Transactions Process   
`curl -X 'GET' \
  'http://localhost:8080/simple' \
  -H 'accept: application/json'`