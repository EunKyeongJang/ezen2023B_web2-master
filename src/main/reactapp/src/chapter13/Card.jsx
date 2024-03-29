export default function Card(props){
    const {title, backgroundcolor, children}=props;

    return(<>
        <div style={{
            margin : 8,
            padding : 8,
            borderRadius : 8,
            boxShadow : "0px, 0px, 4px, grey",
            backgroundColor : backgroundcolor || "white"
        }}>
            {title && <h1>{title}</h1>}
            {children}
        </div>
    
    </>);
}