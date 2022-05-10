import './Kusnir_Nine_Mens_morris.css'
import {Button} from "react-bootstrap";
import {useEffect, useState} from "react";
import fieldService from "./_api/nine_mens_morris_field_service";
import Field from "./Field";
import {addScore} from "../../../_api/score.service";
function Kusnir_Nine_Mens_morris(){
    const [field, setField] = useState(null);

    const handleTileAction = (id, player, serviceAction) => {
        console.log(id);
        console.log("MarkPos");
            serviceAction(id,field?.playerOnTurn.color).then(response => {
                setField(response.data);
                console.log("remove");
            });
    }

    useEffect(() => {
        fieldService.fetchField().then(response => {
            setField(response.data);
            console.log(response.data);

        })
    },[]);

    const handleNewGame = () => {
        fieldService.newGame().then(response => {
            setField(response.data);
        });
    }

    return(
        <div>
            <div>
            <h1>Nine mens morris React</h1>
                <h1>Player on turn: {field?.playerOnTurn.color}</h1>
                <h3>State: {field?.state}</h3>
                <h3>RED score: {field?.player1?.score.points}</h3>
                <h3>BLUE score: {field?.player2?.score.points}</h3>
            </div>
            {field &&
                <Field
                       positions={field.positions}
                       field={field}
                       onMarkPos={(id) => handleTileAction(id,field?.playerOnTurn, fieldService.markPos)}
                       onRemovePos={(id) => handleTileAction(id,field?.playerOnTurn, fieldService.removePos)} />
            }
            <Button className="submit"
                    onClick={handleNewGame}>
                New Game
            </Button>
        </div>
    )
}
export default Kusnir_Nine_Mens_morris;