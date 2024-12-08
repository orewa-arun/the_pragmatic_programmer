# Chapter 2 : Prototyping:

    Prototyping is done to vaidate an idea, identify the risks, to grasp the idea of unknowns, like is it possible to decouple this?, is this how it works?

## General Idea :
    Note that prototyping involves writing disposable code, so every nuance of unwanted specifics (for testing the prototype is ignored even if it is of value to the customer), hence we can use dummy data.
    Most of the time, we won't require writing code to provide a proto, just some diagrams on the board will do, post-it notes could be enough, always use a prototype only to assess the feasibility, risk and the possibility of an implementation. It could be just an UI, a function, a design pattern, an architecture, etc.

### What does it look like in the code:
    You have an external API, you are not sure if you can get the API's response using a key-value data structure, like a Map.
    But you realise that this new practise has added benefits, like you don't have to worry about the unwanted params that the API is retreiving and you don't have to dynamically change the ResponseDTO as per the changing external API's response DTO.
    You are also planning to add a table driven validation, so that you can confirm that you are getting all the necessary data from the external API in the way we wanted.

    Sounds like a situation that requires some prototyping.

