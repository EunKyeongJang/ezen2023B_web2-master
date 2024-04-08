import * as React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

export default function MediaCard(props) {
    console.log(props);
    console.log("MediaCard 실행");
    let bno=props.board.bno;
    let mno_fk=props.board.mno_fk;

  return (
    <Card sx={{ maxWidth: 400 }}>
      <CardMedia
        sx={{ height: 140 }}
        image={"/image/"+props.board.bimgList[0]}
        title="green iguana"
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          {props.board.bno}  
          {props.board.bcontent}
          {props.board.mno_fk}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {props.board.memail}
        </Typography>
      </CardContent>
      <CardActions>
        {/* 삭제버튼 */}
        <Button size="small" onClick={(event)=>props.deleteBoard(event,bno,mno_fk)}>삭제</Button>
        <Button size="small">Learn More</Button>
      </CardActions>
    </Card>
  );
}