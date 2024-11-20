package com.example.e_commerce.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.e_commerce.R
import com.example.e_commerce.viewModel.SignUpViewModel
import com.example.e_commerce.views.widgets.MyTextField
import kotlinx.serialization.Serializable


@Serializable
object SignUpRoute

@Composable
fun Signup(navController: NavController,modifier: Modifier = Modifier , viewModel: SignUpViewModel = hiltViewModel()) {
    // State to hold the text field value


    Box(
        modifier =
        modifier
            .fillMaxSize()
            .background(Color(0, 65, 130, 255))
            .padding(start = 18.dp, end = 18.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Image logo
            Image(
                painter = painterResource(id = R.drawable.route_logo),
                contentDescription = "Logo",
                modifier =
                Modifier
                    .height(71.dp)
                    .width(237.dp),
                contentScale = ContentScale.FillWidth,
            )

            Column(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                // Full Name
                Text(text = "Full Name", color = Color.White, fontSize = 16.sp)
                MyTextField(
                    value = viewModel.fullNameTextField,
                    onValueChange = { viewModel.fullNameTextField = it },
                    label = "Full Name",
                    error = viewModel.fullNameError,
                    onErrorChange = { viewModel.fullNameError = it },
                )

                // Mobile Number
                Text(text = "Mobile Number", color = Color.White, fontSize = 16.sp)
                MyTextField(
                    value = viewModel.mobileNumberTextField,
                    onValueChange = { viewModel.mobileNumberTextField = it },
                    label = "Mobile Number",
                    error = viewModel.mobileNumberError,
                    onErrorChange = { viewModel.mobileNumberError = it },
                )

                // E-mail address
                Text(text = "E-mail address", color = Color.White, fontSize = 16.sp)
                MyTextField(
                    value = viewModel.emailAddressTextField,
                    onValueChange = { viewModel.emailAddressTextField = it },
                    label = "E-mail address",
                    error = viewModel.emailAddressError,
                    onErrorChange = { viewModel.emailAddressError = it },
                )

                // Password
                Text(text = "Password", color = Color.White, fontSize = 16.sp)
                MyTextField(
                    value = viewModel.passwordTextField,
                    onValueChange = { viewModel.passwordTextField = it },
                    label = "Password",
                    error = viewModel.passwordError,
                    onErrorChange = { viewModel.passwordError = it },
                    isPasswordField = true,
                    passwordVisible = viewModel.passwordVisible,
                    onPasswordVisibilityChange = { viewModel.passwordVisible = it },
                )

                Button(
                    onClick = {

                        viewModel.register()


                        if (viewModel.isSuccess) {
                            navController.navigate(HomeRoute) {
                                popUpTo(SignUpRoute) { inclusive = true }
                            }
                        }

                    },
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                        .background(Color.White, shape = RoundedCornerShape(15.dp))
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color(0, 65, 130, 255),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }

}
