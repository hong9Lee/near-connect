rootProject.name = "near-connect"

/** Infra 계층 */
include("near-connect:persistence")

/** Application 계층 */
include("near-connect:api")
include("near-connect:websocket")

/** Domain 계층 */
include("near-connect:core")
