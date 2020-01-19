package buur.frederik.timetowork.service.user

import buur.frederik.timetowork.dao.user.UserDao
import buur.frederik.timetowork.model.User
import buur.frederik.timetowork.service.user.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
@Qualifier("monolith")
class UserServiceMonolith @Autowired constructor(
        @Qualifier("fakeDao") private val userDao: UserDao
//        @Qualifier("postgres") private val userDao: UserDao
) : IUserService {

    override fun createUser(user: User) {
        userDao.insertUser(user = user)
    }

    override fun getAllUsers() = userDao.selectAllUsers()

    override fun getUserById(id: UUID) = userDao.selectUserById(id)

    override fun deleteUserById(id: UUID) = userDao.deleteUserById(id)

    override fun updateUserById(id: UUID, user: User) = userDao.updateUserById(id, user)

}