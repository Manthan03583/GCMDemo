package com.example.gcmdemo.data.model

import com.example.gcmdemo.data.db.entity.Chat
import com.example.gcmdemo.data.db.entity.UserInfo

data class ChatWithUserInfo(
    var mChat: Chat,
    var mUserInfo: UserInfo
)
