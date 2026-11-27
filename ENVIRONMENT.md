# Omega environment setup

Author Siuuuddddd <ksiddhesh010@gmail.com>. Repository https://github.com/Siuuuddddd/Omega.git

Local environment files are ignored. The inherited Kubernetes environment was backed up outside this project and cleared. Supply existing database passwords from databases you control. Third-party credentials are blank. New local JWT and MinIO secrets were generated.

## Variables

| Variable | Purpose and source |
| --- | --- |
| `CONFIG_GIT_URI` | Your Spring Cloud Config Git repository URL containing service runtime configuration |
| `CONFIG_GIT_LABEL` | Branch in your configuration repository |
| `GIT_USERNAME` | Your GitHub username for private config repository access |
| `GIT_PASSWORD` | Create a new GitHub token with read access to your config repository |
| `POSTGRES_PASSWORD` | Existing PostgreSQL administrator password from your database administrator |
| `ACCOUNT_DB_PASSWORD` | Existing account database password from your database administrator |
| `WORKSPACE_DB_PASSWORD` | Existing workspace database password from your database administrator |
| `INTELLIGENCE_DB_PASSWORD` | Existing intelligence database password from your database administrator |
| `JWT_SECRET` | Generated local Base64 JWT signing secret shared across services |
| `MINIO_ROOT_USER` | Local MinIO administrator username |
| `MINIO_ROOT_PASSWORD` | Generated local MinIO administrator password |
| `AI_API_KEY` | Obtain from your configured AI provider |
| `STRIPE_API_KEY` | Obtain your secret API key from Stripe dashboard |
| `STRIPE_WEBHOOK_SECRET` | Obtain the endpoint signing secret from Stripe webhooks |
| `CONFIG_SERVER_URL` | Config server URL, localhost:8888 in IntelliJ and config-service:8888 in Compose |
| `FRONTEND_URL` | Your frontend origin URL |
| `CORS_ALLOWED_ORIGINS` | Comma-separated allowed frontend origins |
| `IMAGE_NAMESPACE` | Your Docker Hub namespace |
| `IMAGE_TAG` | Container image tag you built |
| `APP_HOST` | Your owned website hostname for Kubernetes ingress |
| `API_HOST` | Your owned API hostname for Kubernetes ingress |
| `PREVIEW_DOMAIN` | Your owned preview base domain |
| `REDIS_URL` | Redis connection URL for the preview proxy |
| `ACCOUNT_SERVICE_URI` | Account service URL override |
| `WORKSPACE_SERVICE_URI` | Workspace service URL override |
| `PORT` | Preview proxy listening port |

## IntelliJ

Use JDK 21 and import each module pom.xml as a Maven project. Install common-lib first with `mvnw.cmd install -DskipTests`. For each Spring Boot run configuration, select its module and set its environment variables from the root .env. Use the environment file selector if your IntelliJ version provides it, or enter the values in Environment variables. Spring Boot does not automatically load .env. Start config-service with CONFIG_GIT_URI set, then discovery-service and the application services.

The external configuration repository must provide the existing database, messaging, AI and route settings. Map jwt.secret-key and jwt.secretKey to JWT_SECRET, stripe.api.secret to STRIPE_API_KEY, stripe.webhook.secret to STRIPE_WEBHOOK_SECRET, and app.frontend.url to FRONTEND_URL. Map minio.access-key and minio.secret-key to MINIO_ROOT_USER and MINIO_ROOT_PASSWORD. Configure minio.url and minio.project-bucket there. Configure app.preview.namespace as omega-previews and app.preview.domain from PREVIEW_DOMAIN. This source checkout contains no copy of the original remote configuration.

## Docker Compose

Package all service jars first and run `docker compose up`. Compose passes the root .env to every service and connects clients to config-service. Configure service ports to match compose.yaml in your config repository. Databases, Kafka, Redis and MinIO must be reachable from the containers. Kubernetes preview runners require a Kubernetes cluster.

## Kubernetes

Manifests use ${VARIABLE} templates for owned hostnames, registry and configuration repository. Export values from your environment, render with envsubst, then apply the rendered files with kubectl. Kubernetes does not expand these placeholders. Create app-secrets from k8s/.env in both omega-core and omega-previews. Supply a frontend image you control before deploying frontend.yaml.

## GitHub Actions

Set repository variable IMAGE_NAMESPACE to your Docker Hub namespace. Required repository secrets are DOCKERHUB_USERNAME and DOCKERHUB_TOKEN from Docker Hub, plus GCP_WORKLOAD_IDENTITY_PROVIDER, GCP_SERVICE_ACCOUNT, GCP_CLUSTER and GCP_ZONE from your own workload identity federation and GKE configuration. Runtime app-secrets are provisioned separately.

## Build and runtime validation

Packaging uses -DskipTests and the quoted Maven argument "-Djib.skip=true" to skip the existing image publication step because the existing Spring context tests require the external configuration repository and infrastructure. Third-party runtime testing requires your keys and service configuration.

