package com.example.e_commerce.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_commerce.R
import com.example.e_commerce.views.widgets.MyTextField
import kotlinx.serialization.Serializable


@Serializable
object SignInRoute


@Composable
fun SignIn( navController: NavController) {
    var userNameTextField by remember { mutableStateOf(TextFieldValue("")) }
    var passwordTextField by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by remember { mutableStateOf(false) }
    var userNameError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0, 65, 130, 255))
            .padding(start = 18.dp, end = 18.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(
                painter = painterResource(id = R.drawable.route_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(71.dp)
                    .width(237.dp),
                contentScale = ContentScale.FillWidth,
            )

            Spacer(modifier = Modifier.height(60.dp))


            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "Welcome Back To Route",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Please sign in with your e-mail",
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(text = "User Name", color = Color.White, fontSize = 16.sp)
                MyTextField(
                    value = userNameTextField,
                    onValueChange = { userNameTextField = it },
                    label = "User Name",
                    error = userNameError,
                    onErrorChange = { userNameError = it },
                )

                Text(text = stringResource(R.string.password), color = Color.White, fontSize = 16.sp)
                MyTextField(
                    value = passwordTextField,
                    onValueChange = { passwordTextField = it },
                    label = "Password",
                    error = passwordError,
                    onErrorChange = { passwordError = it },
                    isPasswordField = true,
                    passwordVisible = passwordVisible,
                    onPasswordVisibilityChange = { passwordVisible = it },
                )


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    Text(text = stringResource(R.string.forgot_password), color = Color.White, fontSize = 16.sp)
                }


                Button(
                    onClick = {

                        userNameError = if (userNameTextField.text.isEmpty()) "Required !" else ""
                        passwordError = if (passwordTextField.text.isEmpty()) "Required !" else ""

                        if (userNameError.isEmpty() && passwordError.isEmpty()) {
                            navController.navigate(HomeRoute) {
                                popUpTo(SignInRoute) { inclusive = true }
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                        .background(Color.White, shape = RoundedCornerShape(15.dp))
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                ) {
                    Text(
                        text = stringResource(R.string.login),
                        color = Color(0, 65, 130, 255),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                    )
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                            navController.navigate(SignUpRoute)
                        },
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text = "Don’t have an account? Create Account", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}
