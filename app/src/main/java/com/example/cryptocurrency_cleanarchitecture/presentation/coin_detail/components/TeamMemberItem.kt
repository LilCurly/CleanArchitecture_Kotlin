package com.example.cryptocurrency_cleanarchitecture.presentation.coin_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptocurrency_cleanarchitecture.entities.TeamMember
import com.example.cryptocurrency_cleanarchitecture.presentation.theme.OnBackground

@Composable
fun ComposeTeamMemberItem(teamMember: TeamMember) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp, top = 10.dp)
    ) {
        Text(teamMember.name, fontSize = 18.sp, color = OnBackground)
        Spacer(modifier = Modifier.height(10.dp))
        Text(teamMember.position, fontStyle = FontStyle.Italic, color = OnBackground)
        Spacer(modifier = Modifier.height(1.dp).border(1.dp, OnBackground))
    }
}