package com.airro.unada.chatdetail

data class ChatItem (

    var chatId : String? = null,
    val userId : String? = null,
    val message : String? = null,
    val date : Long? = null,
    var read: Boolean = false
)