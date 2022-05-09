import './Kusnir_Nine_Mens_morris.css'
function Position({position,onMarkPos}){
    let positionClass;
    if("null".localeCompare(position?.player)===0){
        positionClass = position.color === undefined
    }

    const handleClick = () => {
        if(!position.player) {
            onMarkPos(position.id);
        }
    }

    return (
        <td
        onClick={event => handleClick()}>{position.id}</td>
    )
}
export default Position;