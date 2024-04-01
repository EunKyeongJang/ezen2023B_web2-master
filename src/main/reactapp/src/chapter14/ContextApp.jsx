//1. 컴포넌트1 : 조부모
export default function ContextApp(props){
    return(<>
        <ToolBar theme="dark" />
    </>);
}

//2. 컴포넌트2 : 부모
function ToolBar(props){
    console.log(props);
    return(<>
    <ThemedButton theme={props.theme} />
    </>);
}

//3. 컴포넌트3 : 자식
function ThemedButton(props){
    console.log(props);
    return(<>
        <Button theme={props.theme} />
    </>);
}