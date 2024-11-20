package com.example.e_commerce.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.request.RegisterRequestEntity
import com.example.domain.useCases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    var fullNameTextField by  mutableStateOf(TextFieldValue(""))
    var mobileNumberTextField by mutableStateOf(TextFieldValue(""))
    var emailAddressTextField by  mutableStateOf(TextFieldValue(""))
    var passwordTextField by  mutableStateOf(TextFieldValue(""))
    var passwordVisible by  mutableStateOf(false)

    var fullNameError by  mutableStateOf("")
    var mobileNumberError by  mutableStateOf("")
    var emailAddressError by  mutableStateOf("")
    var passwordError by  mutableStateOf("")


    var isSuccess by mutableStateOf(false)


    fun register(){

        var isFormValid = true
        fullNameError = if (fullNameTextField.text.isEmpty()) {
            isFormValid = false
            "Required !"
        } else ""
        mobileNumberError = if (mobileNumberTextField.text.isEmpty()){
            isFormValid = false
            "Required !"
        } else ""
        emailAddressError = if (emailAddressTextField.text.isEmpty()) {
            isFormValid = false
            "Required !"
        } else ""
        passwordError = if (passwordTextField.text.isEmpty()) {
            isFormValid = false
            "Required !"
        } else ""


        if (isFormValid)
            viewModelScope.launch {
                try{

                    val request = RegisterRequestEntity(
                        passwordTextField.text,
                        mobileNumberTextField.text,
                        passwordTextField.text,
                        fullNameTextField.text,
                        emailAddressTextField.text
                        )
                    val response = registerUseCase(request)
                    isSuccess = true

                }catch (e:Exception){

                }
            }
    }

}