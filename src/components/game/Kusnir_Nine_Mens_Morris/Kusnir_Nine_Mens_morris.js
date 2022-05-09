import './Kusnir_Nine_Mens_morris.css'
import {useEffect, useState} from "react";
import fieldService from "./_api/nine_mens_morris_field_service";
import Field from "./Field";
function Kusnir_Nine_Mens_morris(){
    const [field, setField] = useState(null);

    const handleTileAction = (id, player, serviceAction) => {
        console.log(id);
        console.log(field?.player1.color);
            serviceAction(id,encodeURIComponent(field?.player1.color)).then(response => {
                setField(response.data);
                console.log("MarkPos");
            });
    }

    useEffect(() => {
        fieldService.fetchField().then(response => {
            setField(response.data);
            console.log(response.data);
        })
    },[]);

    return(
        <div>
            <div>
            <h1>Nine mens morris React</h1>
                <h1>Player: {field?.player1.color}</h1>
            <h3>State: {field?.state}</h3>
            </div>
            {field &&
                <Field positions={field.positions}
                       field={field}
                onMarkPos={(id) => handleTileAction(id,field?.playerOnTurn, fieldService.markPos)}/>
            }
        </div>
    )
}
export default Kusnir_Nine_Mens_morris;