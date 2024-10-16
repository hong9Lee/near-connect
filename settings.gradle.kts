rootProject.name = "near-connect"

/** Infra 계층 */
include("persistence")

/** Application 계층 */
include("api")
include("websocket")

/** Domain 계층 */
//include("core")
