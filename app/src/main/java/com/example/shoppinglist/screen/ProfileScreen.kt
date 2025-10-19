package com.example.shoppinglist.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppinglist.R
import com.example.shoppinglist.ui.theme.ShoppingListTheme
import com.example.shoppinglist.viewModel.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel:  ProfileViewModel = viewModel(),
    navigateToEdit: () -> Unit
) {
    val currentName by viewModel.name
    val currentDescrition by viewModel.description

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.foto_diri),
            contentDescription = "Foto Diri",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .clip(CircleShape)
                .shadow(elevation = 8.dp, shape = CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = currentName,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            color = Color(0xFF240B41)

        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = currentDescrition,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
            ),
            color = Color(color = 0xFFC58CB5)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxSize().padding(all = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth().height(50.dp),
                color = Color(0xFFC58CB5),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            modifier = Modifier.fillMaxHeight().width(50.dp),
                            shape = MaterialTheme.shapes.extraLarge,
                            color = Color(0xFFC0E5FF),
                            onClick = navigateToEdit
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = null,
                                Modifier.size(20.dp).padding(13.dp),
                                tint = Color(0xFFC58CB5)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "Edit Profil",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                            ),
                            color = Color(0xFF852F6A)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        Modifier.size(50.dp).padding(13.dp),
                        tint = Color(0xFF240B41),
                        )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Surface(
                modifier = Modifier.fillMaxWidth().height(50.dp),
                color = Color(0xFFC58CB5),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            modifier = Modifier.fillMaxHeight().width(50.dp),
                            shape = MaterialTheme.shapes.extraLarge,
                            color = Color(0xFFC0E5FF)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null,
                                Modifier.size(20.dp).padding(13.dp),
                                tint = Color(0xFFC58CB5)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "Email Address",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                            ),
                            color = Color(0xFF852F6A)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        Modifier.size(50.dp).padding(13.dp),
                        tint = Color(0xFF240B41),

                        )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Surface(
                modifier = Modifier.fillMaxWidth().height(50.dp),
                color = Color(0xFFC58CB5),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            modifier = Modifier.fillMaxHeight().width(50.dp),
                            shape = MaterialTheme.shapes.extraLarge,
                            color = Color(0xFFC0E5FF)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = null,
                                Modifier.size(20.dp).padding(13.dp),
                                tint = Color(0xFFC58CB5)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "Phone Number",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                            ),
                            color = Color(0xFF852F6A)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        Modifier.size(50.dp).padding(13.dp),
                        tint = Color(0xFF240B41),

                        )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Surface(
                modifier = Modifier.fillMaxWidth().height(50.dp),
                color = Color(0xFFC58CB5),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            modifier = Modifier.fillMaxHeight().width(50.dp),
                            shape = MaterialTheme.shapes.extraLarge,
                            color = Color(0xFFC0E5FF)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null,
                                Modifier.size(20.dp).padding(13.dp),
                                tint = Color(0xFFC58CB5)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "Change Password",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                            ),
                            color = Color(0xFF852F6A)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        Modifier.size(50.dp).padding(13.dp),
                        tint = Color(0xFF240B41),

                        )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfielScreenPreview() {
    ShoppingListTheme {
        ProfileScreen(
            navigateToEdit = {}
        )
    }
}