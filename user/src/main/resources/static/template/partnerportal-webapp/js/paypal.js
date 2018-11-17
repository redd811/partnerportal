// Render the PayPal button
				paypal.Button.render({
				// Set your environment
				env: 'sandbox', // sandbox | production
				
				// Specify the style of the button
				style: {
				  layout: 'vertical',  // horizontal | vertical
				  size:   'medium',    // medium | large | responsive
				  shape:  'rect',      // pill | rect
				  color:  'gold'       // gold | blue | silver | white | black
				},
				
				// Specify allowed and disallowed funding sources
				//
				// Options:
				// - paypal.FUNDING.CARD
				// - paypal.FUNDING.CREDIT
				// - paypal.FUNDING.ELV
				funding: {
				  allowed: [
				    paypal.FUNDING.CARD,
				    paypal.FUNDING.CREDIT
				  ],
				  disallowed: []
				},
				
				// Enable Pay Now checkout flow (optional)
				commit: true,
				
				// PayPal Client IDs - replace with your own
				// Create a PayPal app: https://developer.paypal.com/developer/applications/create
				client: {
				  sandbox: 'ASwNit2X4FuOTZ2jVX1AtcWqAadp6S1PRAkBTMUMP9LsA-YntmWc5aWd66WHeIj0XiOxujQsqirVvyUQ',
				  production: '<insert production client id>'
				},
				
				// Set up a payment
				payment: function(data, actions) {
				  return actions.payment.create({
				    transactions: [{
				      amount: {
				        total: '30.11',
				        currency: 'PHP',
				        details: {
				          subtotal: '30.00',
				          tax: '0.07',
				          shipping: '0.03',
				          handling_fee: '1.00',
				          shipping_discount: '-1.00',
				          insurance: '0.01'
				        }
				      },
				      description: 'The payment transaction description.',
				      custom: '90048630024435',
				      //invoice_number: '12345', Insert a unique invoice number
				      payment_options: {
				        allowed_payment_method: 'INSTANT_FUNDING_SOURCE'
				      },
				      soft_descriptor: 'ECHI5786786',
				      item_list: {
				        items: [
				        {
				          name: 'hat',
				          description: 'Brown hat.',
				          quantity: '5',
				          price: '3',
				          tax: '0.01',
				          sku: '1',
				          currency: 'PHP'
				        },
				        {
				          name: 'handbag',
				          description: 'Black handbag.',
				          quantity: '1',
				          price: '15',
				          tax: '0.02',
				          sku: 'product34',
				          currency: 'PHP'
				        }],
				        shipping_address: {
				          recipient_name: 'Brian Robinson',
				          line1: '4th Floor',
				          line2: 'Unit #34',
				          city: 'San Jose',
				          country_code: 'US',
				          postal_code: '95131',
				          phone: '011862212345678',
				          state: 'CA'
				        }
				      }
				    }],
				    note_to_payer: 'Contact us for any questions on your order.'
				  });
				},
				
				onAuthorize: function (data, actions) {
				  return actions.payment.execute()
				    .then(function () {
				      window.alert('Payment Complete!');
				    });
				}
				}, '#paypal-button-container');