package com.example.shoppinglist.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppinglist.ui.theme.ShoppingListTheme
import com.example.shoppinglist.viewModel.ProfileViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    viewModel: ProfileViewModel = viewModel (),
    onNavigateBack : () -> Unit
) {
    var inputName by remember { mutableStateOf(viewModel.name.value) }
    var inputDesc by remember { mutableStateOf(viewModel.description.value) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Edit Profil",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        ), color = Color(0xFF852F6A)
                    )
                },
                navigationIcon = {
                    // Tombol back
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Kembali",
                            Modifier.size(30.dp).padding(2.dp),
                            tint = Color(0xFF852F6A)
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(WindowInsets.safeDrawing.asPaddingValues())
                .padding(horizontal = 24.dp)
        ){
            Spacer(modifier = Modifier.height(100.dp))

            OutlinedTextField(
                value = inputName,
                onValueChange = {inputName = it},
                label = {Text("Nama Lengkap")},
                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = inputDesc,
                onValueChange = {inputDesc = it},
                label = {Text("Tambahkan Deskripsi")},
                modifier = Modifier.fillMaxWidth().height(150.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                    viewModel.updateName(inputName)
                    viewModel.updateDescription(inputDesc)

                    onNavigateBack()
                },
                modifier = Modifier.fillMaxWidth().height(50.dp)
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC58CB5),
                    contentColor = Color(0xFF852F6A),
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.DarkGray
                )
            ) {
                    Text("Simpan",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 23.sp
                        ))
            }
        }
    }
}




@Preview
@Composable
fun EditProfileScreenPreview() {
    ShoppingListTheme {
        EditProfileScreen {  }
    }
    
}