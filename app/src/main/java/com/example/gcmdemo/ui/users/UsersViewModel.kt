package com.example.gcmdemo.ui.users

import androidx.lifecycle.*
import com.example.gcmdemo.data.db.entity.User
import com.example.gcmdemo.data.db.repository.DatabaseRepository
import com.example.gcmdemo.ui.DefaultViewModel
import com.example.gcmdemo.data.Event
import com.example.gcmdemo.data.Result


class UsersViewModelFactory(private val myUserID: String) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersViewModel(myUserID) as T
    }
}

class UsersViewModel(private val myUserID: String) : DefaultViewModel() {
    private val repository: DatabaseRepository = DatabaseRepository()

    private val _selectedUser = MutableLiveData<Event<User>>()
    var selectedUser: LiveData<Event<User>> = _selectedUser
    private val updatedUsersList = MutableLiveData<MutableList<User>>()
    val usersList = MediatorLiveData<List<User>>()

    init {
        usersList.addSource(updatedUsersList) { mutableList ->
            usersList.value = updatedUsersList.value?.filter { it.info.id != myUserID }
        }
        loadUsers()
    }

    private fun loadUsers() {
        repository.loadUsers { result: Result<MutableList<User>> ->
            onResult(updatedUsersList, result)
        }
    }

    fun selectUser(user: User) {
        _selectedUser.value = Event(user)
    }
}