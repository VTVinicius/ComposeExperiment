package base_feature.home.home_screen

import androidx.lifecycle.ViewModel
import base_feature.utils.extensions.useCase
import com.example.domain.usecase.referenciadouso.ExampleUseCase
import org.koin.core.component.KoinComponent

class HomeScreenViewModel: ViewModel(), KoinComponent {

    private val searchUserUseCase: ExampleUseCase by useCase()


//    private val getUsersLocalUseCase: GetUsersLocalUseCase by useCase()
//
//    private val _getUsersLocalViewState by viewState<List<GitUserModel>>()
//
//    val getUsersLocalViewState = _getUsersLocalViewState.asLiveData()
//
//    fun getUsersLocal() {
//        getUsersLocalUseCase(
//            onSuccess = {
//                _getUsersLocalViewState.postSuccess(it)
//            },
//            onError = {
//                _getUsersLocalViewState.postError(it)
//            }
//        )
//    }

}