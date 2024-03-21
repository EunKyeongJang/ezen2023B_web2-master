//css파일 호출 : import styles from './Comment.css';
import styles from './Comment.css';
//이미지 파일 호출 : import image from './manggu.jpg';
import image from './manggu.jpg';
// ../ : 상위폴더, ./ : 현재폴더

export default function Comment(props){
    console.log(props);
    return(<div class="wrapper">
        <div>
            <img src={image} class='image' />
        </div>
        <div class="contentContainer">
        <span class="nameText">{props.name}</span>
        <span class="commentText">{props.comment}</span>
        </div>
    </div>)
}