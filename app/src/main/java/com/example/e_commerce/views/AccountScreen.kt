package com.example.e_commerce.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce.R
import com.example.e_commerce.ui.theme.blue
import com.example.e_commerce.views.widgets.MyTextField
import kotlinx.serialization.Serializable


@Serializable
object ProfileRoute

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    // State to hold the text field value
    var fullNameTextField by remember { mutableStateOf(TextFieldValue("")) }
    var mobileNumberTextField by remember { mutableStateOf(TextFieldValue("")) }
    var emailAddressTextField by remember { mutableStateOf(TextFieldValue("")) }
    var passwordTextField by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by remember { mutableStateOf(false) }



    var fullNameError by remember { mutableStateOf("") }
    var mobileNumberError by remember { mutableStateOf("") }
    var emailAddressError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }





    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(horizontal = 10.dp)
    ) {

        Box (modifier = Modifier
            .fillMaxWidth()
            ){
            Image(painterResource(id = R.drawable.appbar_logo), contentDescription ="", Modifier.size(70.dp)  )
        }

        Text(text = "Welcome, User", color = blue, fontWeight = FontWeight.W500, fontSize = 18.sp, modifier = Modifier.padding(vertical = 5.dp))
        Text(text = "mohamed.N@gmail.com" , color = blue,fontSize = 14.sp , modifier = Modifier.padding(vertical = 5.dp))



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.Start
        ) {

            // Full Name
            Text(text = "Your Full Name", color = blue, fontSize = 16.sp)
            MyTextField(
                value = fullNameTextField,
                onValueChange = { fullNameTextField = it },
                label = "Full Name",
                error = fullNameError,
                onErrorChange = { fullNameError = it }

            )

            // Mobile Number
            Text(text = "Your Mobile Number", color = blue, fontSize = 16.sp)
            MyTextField(
                value = mobileNumberTextField,
                onValueChange = { mobileNumberTextField = it },
                label = "Mobile Number",
                error = mobileNumberError,
                onErrorChange = { mobileNumberError = it }
            )

            // E-mail address
            Text(text = "Your E-mail address", color = blue, fontSize = 16.sp)
            MyTextField(
                value = emailAddressTextField,
                onValueChange = { emailAddressTextField = it },
                label = "E-mail address",
                error = emailAddressError,
                onErrorChange = { emailAddressError = it }
            )

            // Password
            Text(text = "Your Password", color = blue, fontSize = 16.sp)
            MyTextField(
                value = passwordTextField,
                onValueChange = { passwordTextField = it },
                label = "Password",
                error = passwordError,
                onErrorChange = { passwordError = it },
                isPasswordField = true,
                passwordVisible = passwordVisible,
                onPasswordVisibilityChange = { passwordVisible = it }
            )



            Button(
                onClick = {

                    fullNameError = if (fullNameTextField.text.isEmpty()) "Required !" else ""
                    mobileNumberError = if (mobileNumberTextField.text.isEmpty()) "Required !" else ""
                    emailAddressError = if (emailAddressTextField.text.isEmpty()) "Required !" else ""
                    passwordError = if (passwordTextField.text.isEmpty()) "Required !" else ""
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)

                    .background(blue, shape = RoundedCornerShape(15.dp))
                    .padding(8.dp)

                ,
                colors = ButtonDefaults.buttonColors(containerColor = blue)
            ) {
                Text(
                    text = "Save",
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        }


    }
}


@Preview
@Composable
private fun ProfileScreenPrev() {
    ProfileScreen()
}

