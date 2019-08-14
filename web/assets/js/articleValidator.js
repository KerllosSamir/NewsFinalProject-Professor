$(document).ready(function() {
    $('#articleForm').bootstrapValidator({
        container: '#messages',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            title: {
                validators: {
                    notEmpty: {
                        message: 'Title is required and cannot be empty'
                    }
                }
            },
            body: {
                validators: {
                    notEmpty: {
                        message: 'Body is required and cannot be empty'
                    }
                }
            },
            title: {
                mainImage: {
                    notEmpty: {
                        message: 'Main image is required and cannot be empty'
                    }
                }
            }
        }
    });
});