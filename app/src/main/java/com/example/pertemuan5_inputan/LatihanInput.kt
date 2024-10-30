package com.example.pertemuan5_inputan


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable

fun Latihaninput(modifier: Modifier = Modifier){
    var nama by remember {mutableStateOf("")}
    var email by remember {mutableStateOf( "")}
    var noHp by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var jenis by remember {mutableStateOf("")}


    var namasave by remember {mutableStateOf("")}
    var emailsave by remember {mutableStateOf( "")}
    var noHpsave by remember {mutableStateOf("")}
    var alamatsave by remember {mutableStateOf("")}
    var jenissave by remember {mutableStateOf("")}
    val listjk = listOf("Laki - Laki", "Perempuan")


    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text("Biodata",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.padding(16.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = {Text( "nama")},
            placeholder = { Text("Masukkan Nama Anda!") }
        )

        Row {
            listjk.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = jenis == item,
                        onClick = {
                            jenis = item
                        }
                    )
                    Text(item)
                }
            }
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = {Text( "email")},
            placeholder = { Text("Masukkan Email Anda!") }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = noHp,
            onValueChange = {noHp = it},
            label = {Text( "noHp")},
            placeholder = { Text("Masukkan noHp Anda!") }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = {Text( "alamat")},
            placeholder = { Text("Masukkan alamat Anda!") }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = jenis,
            onValueChange = {jenis = it},
            label = {Text( "jenis")},
            placeholder = { Text("Masukkan jenis Anda!") }
        )

        Button(onClick = {
            namasave = nama
            emailsave = email
            noHpsave = noHp
            alamatsave = alamat
            jenissave = jenis
        }) {
            Text("submit")
        }

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(contentColor = Color.Blue)
        ) {
            DetailSurat("Nama", namasave)
            DetailSurat("Memilih Jenis Kelamin", jenissave)
            DetailSurat("Email", emailsave)
            DetailSurat("Alamat", alamatsave)
            DetailSurat("No HP", noHpsave)

        }






    }
}

@Composable
fun DetailSurat(judul: String, isinya: String) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),

        ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = isinya,
                modifier = Modifier.weight(2f))
        }


    }

}