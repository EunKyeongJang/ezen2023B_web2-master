export default function ToolBar(props){
    console.log(props);
    //1. props 매개변수
    const {isLoggedIn,onClickLogin, onClickLogout}=props;

    return(<>
            <div>
                {
                    isLoggedIn && <span>환영합니다.</span>
                }
                {
                    isLoggedIn ? (<button onClick={onClickLogout}>로그아웃</button>) : (<button onClick={onClickLogin}>로그인</button>)
                }
            </div>
        </>);
}