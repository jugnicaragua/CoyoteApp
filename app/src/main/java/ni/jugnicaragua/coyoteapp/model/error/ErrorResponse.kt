package ni.jugnicaragua.coyoteapp.model.error

data class ErrorResponse(
    val error: String, // Unauthorized
    val message: String, // Unauthorized
    val path: String, // /api/banks/5/cookies/
    val status: Int, // 401
    val timestamp: String // 2020-03-08T13:26:07.607+0000
)