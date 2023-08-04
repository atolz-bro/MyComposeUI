package com.example.mycomposeui

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeui.ui.theme.ProgressBlue
import com.example.mycomposeui.ui.theme.WhiteGreen
import com.example.mycomposeui.ui.theme.WhiteBlue
import com.example.mycomposeui.ui.theme.WhiteYellow


@Composable
fun RecommendedCard(
        @StringRes title: Int,
        @StringRes subTitle: Int,
        color: Color){
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = color
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .width(130.dp)
        ){
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .background(color = Color.White, CircleShape)
                    .padding(4.dp),
            )
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography
                    .h6.copy(fontSize = 14.sp),
                modifier = Modifier.paddingFromBaseline(24.dp))
            Text(
                text = stringResource(id = subTitle),
                style = MaterialTheme.typography
                    .subtitle1.copy(
                        color = Color.Gray),
                modifier = Modifier.paddingFromBaseline(20.dp))
        }
    }
}

@Preview
@Composable
fun PopularCard(){
    Surface(
        color = Color.Yellow.copy(alpha = 0.3f),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Title(text = "UX Design")
            SubTitle(text = "Design experiences that drive user behaviour and delight people")
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(top = 16.dp)
            ){
                Tag(text = "24 lessons", WhiteYellow)
                Spacer(modifier = Modifier.width(8.dp))
                Tag(text = "42 hours", WhiteYellow)
                Spacer(modifier = Modifier.weight(1f))
                Tag(text = "$345", WhiteYellow)
            }
        }
    }

}

@Preview
@Composable
fun ProgressCard(){
    Surface(
        color = ProgressBlue,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .background(color = Color.White, CircleShape)
                    .padding(4.dp),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column{
                Title(text = "Visual Design")
                SubTitle(text = "10 lessons left")
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null
            )
        }
    }
}

@Composable
fun Section(headerText: String, content : @Composable ()->Unit){
    Column{
        SectionTextHeader(text = headerText)
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
}

@Composable
fun Tag(text : String, color: Color){
    Text(
        text = text,
        style = MaterialTheme.typography
            .subtitle1.copy(
                color = color),
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Color.Black)
            .padding(8.dp)
    )
}

@Composable
fun Title(text: String){
    Text(
        text = text,
        style =  MaterialTheme.typography
            .h6.copy(fontSize = 14.sp)
    )
}

@Composable
fun SubTitle(text: String){
    Text(
        text = text,
        style = MaterialTheme.typography
            .subtitle1.copy(
                color = Color.Gray)
    )
}

@Composable
fun SectionTextHeader(text: String){
    Text(
        text = text,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

@Preview
@Composable
fun SearchBar(){
    var value by  remember{
        mutableStateOf("")
    }

    Surface(
        shape = RoundedCornerShape(32.dp),
        border = BorderStroke(1.dp,Color.Gray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier.weight(1f).padding(8.dp),
                contentAlignment = Alignment.CenterStart
            ){

                BasicTextField(
                    value = value,
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Gray),

                    onValueChange = {
                        value = it
                    },
                    decorationBox = { InnerTextField ->
                        Row{
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                            InnerTextField()
                        }

                    }
                )
                if(value.isEmpty()){
                    Text(
                        "Search the course",
                        modifier = Modifier.padding(start = 24.dp),
                        color = Color.Gray
                    )
                }
            }
            Box(
                modifier = Modifier.width(52.dp).height(52.dp).background(Color.Black),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }

}

@Preview
@Composable
fun AppBar(){
    Row(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Tag("Menu",Color.White)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun SectionHeaderPreview(){
    SectionTextHeader(text = "In Progress")
}
@Preview
@Composable
fun RecommendedCardPreview(){
    Row(
        modifier = Modifier.padding(8.dp)
    ){
        RecommendedCard(
            title = R.string.ui_design,
            subTitle = R.string.ui_design_sub,
            color = WhiteGreen
        )
        Spacer(modifier = Modifier.width(16.dp))
        RecommendedCard(
            title = R.string.python,
            subTitle = R.string.python_sub,
            color = WhiteBlue
        )

    }
}

@Preview
@Composable
fun TutorApp(){

    Column(
        Modifier
            .padding(horizontal = 16.dp)
    ) {
        AppBar(

        )
        Column(
            Modifier
                .verticalScroll(rememberScrollState()),

            ) {
            Section(headerText = "What's new to learn?") {
                com.codelab.basiclayouts.ui.theme.SearchBar()
            }
            Section(headerText = "Recommended for you") {

                Row(

                ) {
                    RecommendedCard(
                        title = R.string.ui_design,
                        subTitle = R.string.ui_design_sub,
                        color = WhiteGreen
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    RecommendedCard(
                        title = R.string.python,
                        subTitle = R.string.python_sub,
                        color = WhiteBlue
                    )

                }
            }
            Section("Popular") {
                PopularCard()
            }
            Section("In Progress") {
                ProgressCard()
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}




