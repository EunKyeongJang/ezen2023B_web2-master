export default function AttendanceBook(props){
    //1. 샘플 데이터
    const students=[
        {id : 1, name : 'Inje'},
        {id : 1, name : 'Steve'},
        {id : 1, name : 'Bill'},
        {id : 1, name : 'Jeff'}
    ]

    return(<>
        <ul>
            {
                //------- jsx 시작
                students.map((student,index)=>{
                    return(<>
                        <li 
                        key={student.id} 
                        id={student.id}
                        className={student.id}
                        >
                            {student.name}
                        </li>
                    </>)
                })
            }
        </ul>
    </>)
}