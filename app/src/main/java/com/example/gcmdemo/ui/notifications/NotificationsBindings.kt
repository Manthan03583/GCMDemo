package com.example.gcmdemo.ui.notifications

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gcmdemo.data.db.entity.UserInfo

@BindingAdapter("bind_notifications_list")
fun bindNotificationsList(listView: RecyclerView, items: List<UserInfo>?) {
    items?.let { (listView.adapter as NotificationsListAdapter).submitList(items) }
}
