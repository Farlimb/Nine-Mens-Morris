import Position from "./Position";
import "./Kusnir_Nine_Mens_morris.css"

function Field({positions,onMarkPos,onRemovePos}) {
    console.log("ESKEREEEEEEEE");
    return (
        <table align="center">
            <tbody>
                        <tr><Position key={`position-${positions[0]}`}
                                      onMarkPos={(x) => onMarkPos(x)}
                                      onRemovePos={(y) => onRemovePos(y)}
                                      position={positions[0]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[1].id}`}
                                          onMarkPos={(x) => {console.log("FIEEEEELD"); onMarkPos(x)}}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[1]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>

                                <Position key={`position-${positions[2].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[2]}/>
                           </tr>
            <tr>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td>|</td>
                            </tr>
                        <tr>

                            <td> |</td>
                            <td> </td>
                            <Position key={`position-${positions[3].id}`}
                                      onMarkPos={(x) => onMarkPos(x)}
                                      onRemovePos={(y) => onRemovePos(y)}
                                      position={positions[3]}/>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <Position key={`position-${positions[4].id}`}
                                      onMarkPos={(x) => onMarkPos(x)}
                                      onRemovePos={(y) => onRemovePos(y)}
                                      position={positions[4]}/>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>

                            <Position key={`position-${positions[5].id}`}
                                      onMarkPos={(x) => onMarkPos(x)}
                                      onRemovePos={(y) => onRemovePos(y)}
                                      position={positions[5]}/>
                            <td> </td>
                            <td>| </td>
                        </tr>
                            <tr>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                            </tr>

                            <tr>
                                <td> |</td>
                                <td> </td>
                                <td> |</td>
                                <td></td>
                                <Position key={`position-${positions[6].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[6]}/>
                                <td>-</td>
                                <td> </td>

                                <Position key={`position-${positions[7].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[7]}/>
                                <td>-</td>
                                <td>-</td>

                                <Position key={`position-${positions[8].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[8]}/>
                                <td> </td>
                                <td>| </td>
                                <td> </td>
                                <td>| </td>
                            </tr>

                            <tr>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                            </tr>

                            <tr>
                                <Position key={`position-${positions[9].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[9]}/>
                                <td>-</td>
                                <Position key={`position-${positions[10].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[10]}/>
                                <td>-</td>
                                <Position key={`position-${positions[11].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[11]}/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <Position key={`position-${positions[12].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[12]}/>
                                <td>-</td>

                                <Position key={`position-${positions[13].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[13]}/>
                                <td>-</td>
                                <Position key={`position-${positions[14].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[14]}/>
                            </tr>
                            <tr>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/><td/>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                            </tr>
                            <tr>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                                <td/>
                                <Position key={`position-${positions[15].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[15]}/>
                                <td/>
                                <td>-</td>
                                <Position key={`position-${positions[16].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[16]}/>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[17].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[17]}/>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                            </tr>
                            <tr>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td>|</td>
                            </tr>
                            <tr>

                                <td> |</td>
                                <td> </td>
                                <Position key={`position-${positions[18].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[18]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[19].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[19]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>

                                <Position key={`position-${positions[20].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[20]}/>
                                <td> </td>
                                <td>| </td>

                            </tr>
                            <tr>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td>|</td>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td>|</td>
                            </tr>
                            <tr>

                                <Position key={`position-${positions[21].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[21]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[22].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[22]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[23].id}`}
                                          onMarkPos={(x) => onMarkPos(x)}
                                          onRemovePos={(y) => onRemovePos(y)}
                                          position={positions[23]}/>

                            </tr>
            </tbody>

        </table>
    )
}

export default Field;

