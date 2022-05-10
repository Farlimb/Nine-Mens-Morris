import {Button, Form} from "react-bootstrap";
import { useForm } from "react-hook-form";
function RatingForm({onSendRating}){
    const {register, handleSubmit, formState: { errors } } = useForm({mode: "onChange"});
    const onSubmit = data => {
        onSendRating(data.rating);
    }

    return(
        <Form onSubmit={handleSubmit(onSubmit)}>
            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Rating:</Form.Label>
                <input className="form-control"
                       type="text"
                       {...register("rating", {
                           minLength: {value: 1, message: "Minimum is 1."},
                           maxLength: {value: 1, message: "Maximum is 1."},
                           required: {value: true, message: "Rating is required."},
                       })}
                       placeholder="Enter your rating here" />
                <Form.Text style={{color: 'red', float: 'right'}}>
                    {errors.rating?.message}
                </Form.Text>
            </Form.Group>
            <Button type="submit">Send</Button>
        </Form>
    );
}

export default RatingForm;