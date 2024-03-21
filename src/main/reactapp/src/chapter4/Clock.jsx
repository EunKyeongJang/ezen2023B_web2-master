function Clock(props){
    let name='유재석';
    //jsx 문법 들어가는곳
    return(
        <div>
            <h1>안녕 리액트 </h1>
            <h2>현재시간 : {new Date().toLocaleString}</h2>
        </div>
    )
}
export default Clock;