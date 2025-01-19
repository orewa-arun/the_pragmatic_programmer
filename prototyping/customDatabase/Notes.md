1. After Creating different types of DB for phonebook, introduce a new field in the record to check which record is feasible.



### Key differentiators when it comes to storing data in plain text rather than in binary format like in word processors:

1) When adding extra fields, it becomes clumsy in binary, having to repeat operations to maintain the standard size.
2) Mistakes can be very expensive in binary storage, for instance, i once tried to add age again for records with age.
Now the logic i wrote based on length doesn't work and it made a mess of my data and was very hard to undo it.

On the other hand, if i had used json or xml for storing data, I could have made a check for the record if the corresponding field exists already?, if not then add. This kind of feasibility for manipulating data isn't available in binary storage. 

Yes, the lack of such ease of manipulation and simplicity is what makes reading binary data fast and random access possible.

### But, we need extensibility and flexibility which we gain in "storing knowledge in plain text".

More and more features open up when we use text manipulation tools like "sed" and "awk", which we will soon cover in the future and store important syntax here in this repo itself.