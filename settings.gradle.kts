rootProject.name = "near-connect"

/** Infra 계층 */
include("apps:persistence")

/** Application 계층 */
include("apps:api")
include("apps:websocket")

/** Domain 계층 */
include("apps:core")
