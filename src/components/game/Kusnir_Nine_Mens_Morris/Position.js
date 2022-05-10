import './Kusnir_Nine_Mens_morris.css'
function Position({position,onMarkPos,onRemovePos}){

    let positionClass;
    if("RED".localeCompare(position.player?.color)) {
        positionClass = position.player?.color === undefined ? 'start' : 'BLUE'
    }
    else {
        positionClass = 'RED'
    }

    const handleClick = () => {
        console.log("aaaaaa");
        onMarkPos(position.id);
    }
    const handleRightClick = (event) => {
        console.log("REMOVE")
        event.preventDefault();
            onRemovePos(position.id);
    }


    return (
        <td className={positionClass}
            onClick={handleClick}
            onContextMenu={handleRightClick}
                >{position.id}</td>
    )
}

export default Position;