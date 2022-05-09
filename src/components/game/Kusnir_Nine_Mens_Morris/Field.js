import Position from "./Position";
import "./Kusnir_Nine_Mens_morris.css"

function Field({positions,onMarkPos}) {
    console.log("asdasd");
    return (
        <table>
            <tbody>
            <tr>
                <Position key={`position-${positions[0]}`}
                          onMarkPos={() => onMarkPos(0)}
                          position={positions[0]}/>
                </tr>
                        <tr>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[1].id}`}
                                          onMarkPos={(x) => {console.log("asdasd"); onMarkPos(x)}}
                                          position={positions[1]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>

                                <Position key={`position-${positions[2].id}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[2]}/>
                           </tr>
            {/*<tr>
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
                                <Position key={`position-${positions[6]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[6]}/>
                                <td>-</td>
                                <td> </td>

                                <Position key={`position-${positions[7]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[7]}/>
                                <td>-</td>
                                <td>-</td>

                                <Position key={`position-${positions[8]}`}
                                          onMarkPos={() => onMarkPos()}
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
                                <Position key={`position-${positions[9]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[9]}/>
                                <td>-</td>
                                <Position key={`position-${positions[10]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[10]}/>
                                <td>-</td>
                                <Position key={`position-${positions[11]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[11]}/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <td/>
                                <Position key={`position-${positions[12]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[12]}/>
                                <td>-</td>

                                <Position key={`position-${positions[13]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[13]}/>
                                <td>-</td>
                                <Position key={`position-${positions[14]}`}
                                          onMarkPos={() => onMarkPos()}
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
                                <Position key={`position-${positions[15]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[15]}/>
                                <td/>
                                <td>-</td>
                                <Position key={`position-${positions[16]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[16]}/>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[17]}`}
                                          onMarkPos={() => onMarkPos()}
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
                                <Position key={`position-${positions[18]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[18]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[19]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[19]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>

                                <Position key={`position-${positions[20]}`}
                                          onMarkPos={() => onMarkPos()}
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

                                <Position key={`position-${positions[21]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[21]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[22]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[22]}/>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <Position key={`position-${positions[23]}`}
                                          onMarkPos={() => onMarkPos()}
                                          position={positions[23]}/>

                            </tr>*/}
            </tbody>

        </table>
    )
}

export default Field;

