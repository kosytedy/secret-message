# Secret message
This software helps to encrypt and decrypt text using a user-provided key. It is a safe way to send an encrypted message to someone while handing them the key, as without the key, no one can be able to decrypt the message. It uses Advanced Encryption Standard (AES) algorithm to encrypt and decrypt messages.


## Encryption

```
curl -d '{"rawMessage":"Here is my secret message", "key":"secret"}' -H "Content-Type: application/json" -X POST http://localhost:8080/encrypt

{
	"id": "9518e76a-c6d8-4d2e-be9e-04521effa816",
	"message": "UW+ftEIufIK2h6X/x9iK5Q==",
	"createdAt": "2020-10-11T10:27:21.561"
}
```

## Decryption

```
curl -d '{"message":"UW+ftEIufIK2h6X/x9iK5Q==", "key":"secret"}' -H "Content-Type: application/json" -X POST http://localhost:8080/decrypt

{
	"decryptedMessage": "Here is my secret message",
}
```